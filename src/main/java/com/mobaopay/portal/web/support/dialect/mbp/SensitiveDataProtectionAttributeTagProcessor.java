package com.mobaopay.portal.web.support.dialect.mbp;

import com.mobaopay.common.util.SensitiveDataProtectUtil;
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
public class SensitiveDataProtectionAttributeTagProcessor extends AbstractAttributeTagProcessor {

    private static final String ATTR_NAME = "sensitive-data-protection";
    private static final int PRECEDENCE = 12000;

    public SensitiveDataProtectionAttributeTagProcessor(String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, PRECEDENCE, true);
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue, IElementTagStructureHandler structureHandler) {
        final IEngineConfiguration configuration = context.getConfiguration();

        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);

        final IStandardExpression expression = parser.parseExpression(context, attributeValue);

        String text = expression.execute(context).toString();

        structureHandler.setBody(HtmlEscape.escapeHtml5(SensitiveDataProtectUtil.protectCardNo(text)), false);
    }
}
