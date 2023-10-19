package org.egov.common.models.referralmanagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import digit.models.coremodels.AuditDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.egov.common.models.project.AdditionalFields;
import org.egov.common.models.referralmanagement.sideeffect.SideEffect;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Referral {

    @JsonProperty("id")
    @Size(min = 2, max = 64)
    private String id;

    @JsonProperty("clientReferenceId")
    @Size(min = 2, max = 64)
    private String clientReferenceId;

    @JsonProperty("projectBeneficiaryId")
    @Size(min = 2, max = 64)
    private String projectBeneficiaryId;

    @JsonProperty("projectBeneficiaryClientReferenceId")
    @Size(min = 2, max = 64)
    private String projectBeneficiaryClientReferenceId;

    @JsonProperty("referrerId")
    @Size(min = 2, max = 64)
    private String referrerId;

    @JsonProperty("recipientType")
    private String recipientType;

    @JsonProperty("recipientId")
    @Size(min = 2, max = 64)
    private String recipientId;

    @JsonProperty("reasons")
    @NotNull
    @Size(min=1)
    private List<String> reasons;

    @JsonProperty("sideEffect")
    private SideEffect sideEffect;

    @JsonProperty("tenantId")
    @NotNull
    @Size(min=2, max = 1000)
    private String tenantId;

    @JsonProperty("isDeleted")
    private Boolean isDeleted = Boolean.FALSE;

    @JsonProperty("rowVersion")
    private Integer rowVersion;

    @JsonProperty("auditDetails")
    @Valid
    private AuditDetails auditDetails;

    @JsonProperty("clientAuditDetails")
    @Valid
    private AuditDetails clientAuditDetails;

    @JsonProperty("additionalFields")
    @Valid
    private AdditionalFields additionalFields;

    @JsonIgnore
    private Boolean hasErrors = Boolean.FALSE;
}
