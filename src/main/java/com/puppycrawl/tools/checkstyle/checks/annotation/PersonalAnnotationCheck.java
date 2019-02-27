package com.puppycrawl.tools.checkstyle.checks.annotation;

import com.puppycrawl.tools.checkstyle.StatelessCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.utils.AnnotationUtil;

/**
 * @ Description:
 * @ Author:         meixy@elab-plus.com
 * @ Create Date:    16:08 2019/2/27
 * @ Modifier:
 * @ Modify Date:
 */
@StatelessCheck
public class PersonalAnnotationCheck extends AbstractCheck {

    public static final String MSG_KEY_ANNOTATION_MISSING_APIOPERATION = "annotation.missing.ApiOperation";

    private static final String APIOPERATION = "ApiOperation";

    private static final String FQ_APIOPERATION = "io.swagger.annotations." + APIOPERATION;;

    public static final String MSG_KEY_ANNOTATION_MISSING_EXCEPTIONHANDLE = "annotation.missing.ExceptionHandle";

    private static final String EXCEPTIONHANDLE = "ExceptionHandle";

    private static final String FQ_EXCEPTIONHANDLE = "com.elab.core.aop.annotations." + EXCEPTIONHANDLE;;


    /**
     * Returns the default token a check is interested in. Only used if the
     * configuration for a check does not define the tokens.
     *
     * @return the default tokens
     * @see TokenTypes
     */
    @Override
    public int[] getDefaultTokens() {
        return getRequiredTokens();
    }

    /**
     * The configurable token set.
     * Used to protect Checks against malicious users who specify an
     * unacceptable token set in the configuration file.
     * The default implementation returns the check's default tokens.
     *
     * @return the token set this check is designed for.
     * @see TokenTypes
     */
    @Override
    public int[] getAcceptableTokens() {
        return new int[0];
    }

    /**
     * The tokens that this check must be registered for.
     *
     * @return the token set this must be registered for.
     * @see TokenTypes
     */
    @Override
    public int[] getRequiredTokens() {
        return new int[]
                {TokenTypes.METHOD_DEF, };
    }

    /**
     * Called to process a token.
     *
     * @param ast the token to process
     */
    @Override
    public void visitToken(DetailAST ast) {

        if (!AnnotationUtil.containsAnnotation(ast, APIOPERATION)
                && !AnnotationUtil.containsAnnotation(ast, FQ_APIOPERATION)) {
            log(ast.getLineNo(), MSG_KEY_ANNOTATION_MISSING_APIOPERATION);
        }else{

        }

        if (!AnnotationUtil.containsAnnotation(ast, EXCEPTIONHANDLE)
                && !AnnotationUtil.containsAnnotation(ast, FQ_EXCEPTIONHANDLE)) {
            log(ast.getLineNo(), MSG_KEY_ANNOTATION_MISSING_EXCEPTIONHANDLE);
        }else{

        }
    }

}
