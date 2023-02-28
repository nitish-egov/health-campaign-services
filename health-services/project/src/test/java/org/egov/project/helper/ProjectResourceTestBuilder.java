package org.egov.project.helper;

import org.egov.common.helper.AuditDetailsTestBuilder;
import org.egov.project.web.models.ProjectProductVariant;
import org.egov.project.web.models.ProjectResource;

public class ProjectResourceTestBuilder {

    private final ProjectResource.ProjectResourceBuilder builder;

    public ProjectResourceTestBuilder() {
        this.builder = ProjectResource.builder();
    }

    public static ProjectResourceTestBuilder builder() {
        return new ProjectResourceTestBuilder();
    }

    public ProjectResource build() {
        return this.builder.build();
    }

    public ProjectResourceTestBuilder withProjectResource() {
        this.builder.id("some-id")
                .tenantId("default")
                .projectId("project-id")
                .resource(ProjectProductVariant.builder()
                        .productVariantId("pv-101")
                        .isBaseUnitVariant(Boolean.FALSE)
                        .type("type")
                        .build())
                .isDeleted(false)
                .rowVersion(1)
                .hasErrors(false)
                .auditDetails(AuditDetailsTestBuilder.builder().withAuditDetails().build())
                .endDate(100L)
                .startDate(100L).build();
        return this;
    }

    public ProjectResourceTestBuilder withId(String id) {
        this.builder.id(id);
        return this;
    }
}
