package com.mobaopay.portal.web.support.dialect.mbp;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IOpenElementTag;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ruby on 2016/6/3.
 * Email:liyufeng_23@163.com
 */
public class WeekdayModelProcessor extends AbstractAttributeModelProcessor {

    private static final String ATTR_NAME = "weekday";
    private static final int PRECEDENCE = 100;

    public WeekdayModelProcessor(String dialectPrefix) {
        super(
            TemplateMode.HTML,
            dialectPrefix,
            null,
            false,
            ATTR_NAME,
            true,
            PRECEDENCE,
            true
        );
    }

    @Override
    protected void doProcess(ITemplateContext context, IModel model, AttributeName attributeName, String attributeValue, IElementModelStructureHandler structureHandler) {
        if(!checkMarkup(context)){
            throw new TemplateProcessingException("The" + ATTR_NAME + "attribute can only be used inside a markup element with class \"main\"");
        }

        final Calendar now = Calendar.getInstance(context.getLocale());
        final int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek == Calendar.FRIDAY){
            final IModelFactory modelFactory = context.getModelFactory();

            model.add(modelFactory.createOpenElementTag("h4"));
            model.add(modelFactory.createText("今天星期五"));
            model.add(modelFactory.createCloseElementTag("h4"));
        }
    }

    private static boolean checkMarkup(final ITemplateContext context) {
        final List<IProcessableElementTag> elementStack = context.getElementStack();
        if(elementStack.size() < 2) {
            return false;
        }
        final IProcessableElementTag container = elementStack.get(elementStack.size()-2);
        if(!(container instanceof IOpenElementTag)) {
            return false;
        }
        final String classValue = container.getAttributeValue("class");
        return classValue != null && classValue.equals("main");
    }
}
