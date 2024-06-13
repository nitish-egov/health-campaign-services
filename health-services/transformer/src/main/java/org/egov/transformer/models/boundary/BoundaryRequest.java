package org.egov.transformer.models.boundary;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.validation.annotation.Validated;

/**
 * BoundaryRequest
 */
@Validated

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoundaryRequest {

    @JsonProperty("RequestInfo")
    @Valid
    private RequestInfo requestInfo = null;

    @Valid
    @NotNull
    @JsonProperty("Boundary")
    @Size(min = 1, max = 300)
    private List<Boundary> boundary = null;

}
