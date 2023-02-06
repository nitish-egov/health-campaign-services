package org.egov.project.validator.staff;

import org.egov.common.models.Error;
import org.egov.common.validator.Validator;
import org.egov.project.web.models.ProjectStaff;
import org.egov.project.web.models.ProjectStaffBulkRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.egov.common.utils.CommonUtils.populateErrorDetails;
import static org.egov.common.utils.ValidatorUtils.getErrorForIsDelete;

@Component
@Order(2)
public class PsIsDeletedValidator implements Validator<ProjectStaffBulkRequest, ProjectStaff> {

    @Override
    public Map<ProjectStaff, List<Error>> validate(ProjectStaffBulkRequest request) {
        HashMap<ProjectStaff, List<Error>> errorDetailsMap = new HashMap<>();
        List<ProjectStaff> validIndividuals = request.getProjectStaff();
        validIndividuals.stream().filter(ProjectStaff::getIsDeleted).forEach(individual -> {
            Error error = getErrorForIsDelete();
            populateErrorDetails(individual, error, errorDetailsMap);
        });
        return errorDetailsMap;
    }
}
