package it.coderit.demos.boot.eserciziofinale.api.validation;

import it.coderit.demos.boot.eserciziofinale.api.model.Contract;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EndDateAfterStartDateValidator
        implements ConstraintValidator<EndDateAfterStartDate, Contract> {
    @Override
    public void initialize(EndDateAfterStartDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Contract contract, ConstraintValidatorContext constraintValidatorContext) {
        if (contract.getEndDate() == null) {
            return true;
        }
        if (contract.getStartDate() == null) {
            return true;
        }
        boolean result = contract.getEndDate().isAfter(contract.getStartDate());
        if(!result) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                            "End date must be after start date"
                    )
                    .addPropertyNode("endDate")
                    .addConstraintViolation();
        }
        return result;
    }
}
