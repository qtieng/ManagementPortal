package org.radarcns.management.web.rest.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

@Component
public class CustomPreZuulFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(CustomPreZuulFilter.class);
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getRequest().getRequestURI().contains("/oauth/token")) {
            byte[] encoded;
            try {
                // get this from properties, this will allow us to use ENV variables for docker
                encoded = Base64.encode("ManagementPortalapp:my-secret-token-to-change-in-production".getBytes("UTF-8"));
                ctx.addZuulRequestHeader("Authorization", "Basic " + new String(encoded));
                final HttpServletRequest req = ctx.getRequest();

                final String refreshToken = extractRefreshToken(req);
                if (refreshToken != null) {
                    final Map<String, String[]> param = new HashMap<String, String[]>();
                    param.put("refresh_token", new String[] { refreshToken });
                    param.put("grant_type", new String[] { "refresh_token" });

                    ctx.setRequest(new CustomHttpServletRequest(req, param));
                }
            } catch (UnsupportedEncodingException e) {
                logger.error("Error occured in pre filter", e);
            }
        }
        return null;
    }

    private String extractRefreshToken(HttpServletRequest req) {
        final Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase("rft")) {
                    return cookies[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return -2;
    }

    @Override
    public String filterType() {
        return "pre";
    }
}
