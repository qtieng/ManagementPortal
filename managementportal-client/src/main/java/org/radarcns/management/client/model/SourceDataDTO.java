/*
 * ManagementPortal API
 * ManagementPortal API documentation
 *
 * OpenAPI spec version: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.radarcns.management.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.radarcns.management.client.model.MinimalSourceTypeDTO;

/**
 * SourceDataDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-01T13:18:11.102+01:00")
public class SourceDataDTO {
  /**
   * Gets or Sets dataClass
   */
  public enum DataClassEnum {
    @SerializedName("RAW")
    RAW("RAW"),
    
    @SerializedName("DERIVED")
    DERIVED("DERIVED"),
    
    @SerializedName("VENDOR")
    VENDOR("VENDOR");

    private String value;

    DataClassEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("dataClass")
  private DataClassEnum dataClass = null;

  @SerializedName("enabled")
  private Boolean enabled = null;

  @SerializedName("frequency")
  private String frequency = null;

  @SerializedName("id")
  private Long id = null;

  @SerializedName("keySchema")
  private String keySchema = null;

  /**
   * Gets or Sets processingState
   */
  public enum ProcessingStateEnum {
    @SerializedName("RAW")
    RAW("RAW"),
    
    @SerializedName("DERIVED")
    DERIVED("DERIVED"),
    
    @SerializedName("VENDOR")
    VENDOR("VENDOR");

    private String value;

    ProcessingStateEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("processingState")
  private ProcessingStateEnum processingState = null;

  @SerializedName("provider")
  private String provider = null;

  @SerializedName("sourceDataName")
  private String sourceDataName = null;

  @SerializedName("sourceDataType")
  private String sourceDataType = null;

  @SerializedName("sourceType")
  private MinimalSourceTypeDTO sourceType = null;

  @SerializedName("topic")
  private String topic = null;

  @SerializedName("unit")
  private String unit = null;

  @SerializedName("valueSchema")
  private String valueSchema = null;

  public SourceDataDTO dataClass(DataClassEnum dataClass) {
    this.dataClass = dataClass;
    return this;
  }

   /**
   * Get dataClass
   * @return dataClass
  **/
  @ApiModelProperty(example = "null", value = "")
  public DataClassEnum getDataClass() {
    return dataClass;
  }

  public void setDataClass(DataClassEnum dataClass) {
    this.dataClass = dataClass;
  }

  public SourceDataDTO enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Get enabled
   * @return enabled
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public SourceDataDTO frequency(String frequency) {
    this.frequency = frequency;
    return this;
  }

   /**
   * Get frequency
   * @return frequency
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public SourceDataDTO id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SourceDataDTO keySchema(String keySchema) {
    this.keySchema = keySchema;
    return this;
  }

   /**
   * Get keySchema
   * @return keySchema
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getKeySchema() {
    return keySchema;
  }

  public void setKeySchema(String keySchema) {
    this.keySchema = keySchema;
  }

  public SourceDataDTO processingState(ProcessingStateEnum processingState) {
    this.processingState = processingState;
    return this;
  }

   /**
   * Get processingState
   * @return processingState
  **/
  @ApiModelProperty(example = "null", value = "")
  public ProcessingStateEnum getProcessingState() {
    return processingState;
  }

  public void setProcessingState(ProcessingStateEnum processingState) {
    this.processingState = processingState;
  }

  public SourceDataDTO provider(String provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public SourceDataDTO sourceDataName(String sourceDataName) {
    this.sourceDataName = sourceDataName;
    return this;
  }

   /**
   * Get sourceDataName
   * @return sourceDataName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSourceDataName() {
    return sourceDataName;
  }

  public void setSourceDataName(String sourceDataName) {
    this.sourceDataName = sourceDataName;
  }

  public SourceDataDTO sourceDataType(String sourceDataType) {
    this.sourceDataType = sourceDataType;
    return this;
  }

   /**
   * Get sourceDataType
   * @return sourceDataType
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getSourceDataType() {
    return sourceDataType;
  }

  public void setSourceDataType(String sourceDataType) {
    this.sourceDataType = sourceDataType;
  }

  public SourceDataDTO sourceType(MinimalSourceTypeDTO sourceType) {
    this.sourceType = sourceType;
    return this;
  }

   /**
   * Get sourceType
   * @return sourceType
  **/
  @ApiModelProperty(example = "null", value = "")
  public MinimalSourceTypeDTO getSourceType() {
    return sourceType;
  }

  public void setSourceType(MinimalSourceTypeDTO sourceType) {
    this.sourceType = sourceType;
  }

  public SourceDataDTO topic(String topic) {
    this.topic = topic;
    return this;
  }

   /**
   * Get topic
   * @return topic
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public SourceDataDTO unit(String unit) {
    this.unit = unit;
    return this;
  }

   /**
   * Get unit
   * @return unit
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public SourceDataDTO valueSchema(String valueSchema) {
    this.valueSchema = valueSchema;
    return this;
  }

   /**
   * Get valueSchema
   * @return valueSchema
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getValueSchema() {
    return valueSchema;
  }

  public void setValueSchema(String valueSchema) {
    this.valueSchema = valueSchema;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceDataDTO sourceDataDTO = (SourceDataDTO) o;
    return Objects.equals(this.dataClass, sourceDataDTO.dataClass) &&
        Objects.equals(this.enabled, sourceDataDTO.enabled) &&
        Objects.equals(this.frequency, sourceDataDTO.frequency) &&
        Objects.equals(this.id, sourceDataDTO.id) &&
        Objects.equals(this.keySchema, sourceDataDTO.keySchema) &&
        Objects.equals(this.processingState, sourceDataDTO.processingState) &&
        Objects.equals(this.provider, sourceDataDTO.provider) &&
        Objects.equals(this.sourceDataName, sourceDataDTO.sourceDataName) &&
        Objects.equals(this.sourceDataType, sourceDataDTO.sourceDataType) &&
        Objects.equals(this.sourceType, sourceDataDTO.sourceType) &&
        Objects.equals(this.topic, sourceDataDTO.topic) &&
        Objects.equals(this.unit, sourceDataDTO.unit) &&
        Objects.equals(this.valueSchema, sourceDataDTO.valueSchema);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataClass, enabled, frequency, id, keySchema, processingState, provider, sourceDataName, sourceDataType, sourceType, topic, unit, valueSchema);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceDataDTO {\n");
    
    sb.append("    dataClass: ").append(toIndentedString(dataClass)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    keySchema: ").append(toIndentedString(keySchema)).append("\n");
    sb.append("    processingState: ").append(toIndentedString(processingState)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    sourceDataName: ").append(toIndentedString(sourceDataName)).append("\n");
    sb.append("    sourceDataType: ").append(toIndentedString(sourceDataType)).append("\n");
    sb.append("    sourceType: ").append(toIndentedString(sourceType)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    valueSchema: ").append(toIndentedString(valueSchema)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

