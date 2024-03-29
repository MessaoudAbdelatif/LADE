package com.lade.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

  private String firstFieldName;
  private String secondFieldName;
  private String errorMessageName;

  @Override
  public void initialize(final FieldMatch constraintAnnotation) {
    firstFieldName = constraintAnnotation.first();
    secondFieldName = constraintAnnotation.second();
    errorMessageName = constraintAnnotation.errorMessage();
  }

  @Override
  public boolean isValid(final Object value, final ConstraintValidatorContext cvc) {
    boolean toReturn = false;

    try {
      final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
      final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

      toReturn =
          firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
    } catch (final Exception e) {
      //ignore
    }
    //If the validation failed
    if (!toReturn) {
      cvc.disableDefaultConstraintViolation();
      //In the initialiaze method you get the errorMessage: constraintAnnotation.message();
      cvc.buildConstraintViolationWithTemplate(errorMessageName).addPropertyNode(secondFieldName)
          .addConstraintViolation();
    }
    return toReturn;
  }
}