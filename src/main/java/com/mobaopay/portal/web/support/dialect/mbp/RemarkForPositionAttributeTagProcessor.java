package com.mobaopay.portal.web.support.dialect.mbp;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

/**
 * Created by ruby on 2016/6/2.
 * Email:liyufeng_23@163.com
 */
public class RemarkForPositionAttributeTagProcessor extends AbstractAttributeTagProcessor {

    private static final String ATTR_NAME = "remark";
    private static final int PRECEDENCE = 12000;

    public RemarkForPositionAttributeTagProcessor(final String dialectPrefix) {
        super(
                TemplateMode.HTML, // This processor will apply only to HTML m
                dialectPrefix,     // Prefix to be applied to name for matchin
                null,              // No tag name: match any tag name
                false,             // No prefix to be applied to tag name
                ATTR_NAME,         // Name of the attribute that will be match
                true,              // Apply dialect prefix to attribute name
                PRECEDENCE,        // Precedence (inside dialect's precedence)
                true);             // Remove the matched attribute afterwards
    }


    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue, IElementTagStructureHandler structureHandler) {

        final IEngineConfiguration configuration = context.getConfiguration();
        /**
         * Obtain the Thymeleaf Standard Expression parser
         */
        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);

        /**
         * Parse the attribute value as a Thymeleaf Standard Expression
         */
        final IStandardExpression expression = parser.parseExpression(context, attributeValue);

        /**
         * Execute the expression just parsed
         */
        final Integer position = Integer.valueOf( expression.execute(context).toString() );

        /**
         *  If no remark is to be applied, just set an empty body to this tag
         */
        if (position != 2 && position != 5) {
            structureHandler.setBody("", false);   // false == 'non-processable'
            return;
        }


        /**
        * Message should be internationalized, so we ask the engine to resolve
        * the message 'remarks.{REMARK}' (e.g. 'remarks.RELEGATION'). No
        * parameters are needed for this message.
        *
        * Also, we will specify to "use absent representation" so that, if this
        * message entry didn't exist in our resource bundles, an absent-message
        * label will be shown.
        */
        final String i18nMessage =
                context.getMessage(
                        RemarkForPositionAttributeTagProcessor.class,
                        "remarks." + position.toString(),
                        new Object[0],
                        true);

        /**
        * Set the computed message as the body of the tag, HTML-escaped and
        * non-processable (hence the 'false' argument)
        */
        structureHandler.setBody(HtmlEscape.escapeHtml5(i18nMessage), false);
    }
}
