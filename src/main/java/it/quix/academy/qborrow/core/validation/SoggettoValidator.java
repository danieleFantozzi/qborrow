package it.quix.academy.qborrow.core.validation;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.quix.framework.core.model.UserContext;
import it.quix.framework.core.validation.api.InvalidConstraint;
import it.quix.framework.core.validation.InvalidConstraintImpl;
import it.quix.academy.qborrow.core.model.Soggetto;
import it.quix.academy.qborrow.core.search.SoggettoSearch;

/**
 * Validator for the Soggetto object. Annotation validation is automatically
 * performed. To add custom validation insert code into customValidation method
 * and fill an InvalidConstraint set.
 *
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT
 */
public class SoggettoValidator extends QborrowAbstractValidator<Soggetto> {

    private static Log log = LogFactory.getLog(SoggettoValidator.class);

    /**
     * Perform custom validation on a Soggetto object
     * 
     * @param userContext
     *            user context of the logged user
     * @param errors
     *            set of invalid constraint to fill with this method, if errors
     *            are present
     * @param propertyPath
     *            the path of the object in the objectGraph. It uses .notation
     *            like user.address[0]e
     * @param soggetto
     *            object to validate
     * @param groups
     *            group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     */
    @Override
    protected void customValidation(UserContext userContext, Set<InvalidConstraint<?>> errors, String propertyPath, Soggetto soggetto, String... groups) {
        if (log.isDebugEnabled()) {
            log.debug("Call customValidation method for class SoggettoValidator ");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(soggetto.getDataCompleanno());
        int monthCompleanno = cal.get(Calendar.MONTH);
        int dayCompleanno = cal.get(Calendar.DAY_OF_MONTH);
        int dayCorrente = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int monthCorrente = Calendar.getInstance().get(Calendar.MONTH);
        int currentYearInt = Calendar.getInstance().get(Calendar.YEAR);
        int compleannoYearInt = cal.get(Calendar.YEAR);
        if (soggetto.getDataCompleanno() != null) {
            Date yearCompleannoDate = soggetto.getDataCompleanno();
            Date currentYear = new Date();

            if (currentYear.before(yearCompleannoDate)) {
                InvalidConstraint<Soggetto> ic2 =
                    new InvalidConstraintImpl<Soggetto>(Soggetto.class, "error.dataNelFuturo", propertyPath + "dataCompleanno", soggetto,
                        soggetto.getDataCompleanno());
                errors.add(ic2);
            } else {
                if (monthCorrente - monthCompleanno < 0) {

                    currentYearInt = currentYearInt - 1;
                } else if (dayCorrente - dayCompleanno < 0) {
                    currentYearInt = currentYearInt - 1;
                }
                if ((currentYearInt - compleannoYearInt) < 18) {

                    InvalidConstraint<Soggetto> ic1 =
                        new InvalidConstraintImpl<Soggetto>(Soggetto.class, "error.nonMaggiorenne", propertyPath + "dataCompleanno", soggetto,
                            soggetto.getDataCompleanno());
                    errors.add(ic1);
                }
            }
            
            if(soggetto.getEmail()==null){
            	InvalidConstraint<Soggetto> ic1 =
                        new InvalidConstraintImpl<Soggetto>(Soggetto.class, "error.emailNonValida", propertyPath + "email", soggetto,
                            soggetto.getEmail());
                    errors.add(ic1);
                }
            
            else{                
            	Pattern pattern=Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
            	Matcher matcher=pattern.matcher(soggetto.getEmail());
            	if (matcher.matches()==false) {

                    InvalidConstraint<Soggetto> ic1 =
                        new InvalidConstraintImpl<Soggetto>(Soggetto.class, "error.emailNonValida", propertyPath + "email", soggetto,
                            soggetto.getEmail());
                    errors.add(ic1);
                }
            }
            	
            }
            

            // insert here custom validations for Soggetto model
            // after a validation check fail create a new InvalidContraint of the
            // validated type
            // and instantiate an InvalidContraintImpl of the validated type with
            // the error information, es:
            // InvalidConstraint<Type> ic = new
            // InvalidConstraintImpl<Type>(Type.class, message, propertyPath,
            // rootBean, value);
            // where:
            // [message] is the name of a bundle which contains the appropriate
            // error message
            // [propertyPath] is the path from the root bean to the property which
            // generated the error
            // [rootBean] is the root bean being validated
            // [value] is the value of the property which generated the error
            // in the end, add the new invalid constraint to the errors array, es:
            // errors.add(ic);
        

    }
}