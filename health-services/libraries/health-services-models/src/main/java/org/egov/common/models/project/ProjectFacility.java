package org.egov.common.models.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.egov.common.models.core.EgovModel;
import org.springframework.validation.annotation.Validated;

/**
* This object defines the mapping of a facility to a project.
*/
@ApiModel(description = "This object defines the mapping of a facility to a project.")
@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectFacility extends EgovModel {

    @JsonProperty("facilityId")
    @NotNull
    @Size(min=2,max=64)
    private String facilityId = null;

    @JsonProperty("projectId")
    @NotNull
    @Size(min=2,max=64)
    private String projectId = null;

    //TODO remove
    @JsonProperty("isDeleted")
    private Boolean isDeleted = Boolean.FALSE;


}