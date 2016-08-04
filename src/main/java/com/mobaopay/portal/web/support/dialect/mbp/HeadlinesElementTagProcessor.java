package com.mobaopay.portal.web.support.dialect.mbp;

import com.mobaopay.portal.service.BusinessService;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring4.context.SpringContextUtils;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by ruby on 2016/6/3.
 * Email:liyufeng_23@163.com
 */
public class HeadlinesElementTagProcessor extends AbstractElementTagProcessor {

    private static final String TAG_NAME = "headlines";
    private static final int PRECEDENCE = 1000;

    private final Random rand = new Random(System.currentTimeMillis());

    public HeadlinesElementTagProcessor(String dialectPrefix) {
        super(
                TemplateMode.HTML,  // This processor will apply only to HTML mode
                dialectPrefix,      // Prefix to be applied to name for matching
                TAG_NAME,           // Tag name: match specifically this tag
                true,               // Apply dialect prefix to tag name
                null,               // No attribute name: will match by tag name
                false,              // No prefix to be applied to attribute name
                PRECEDENCE          // Precedence (inside dialect's own precedence)
        );
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, IElementTagStructureHandler structureHandler) {
        /**
         * Obtain the Spring application context.
         */
        final ApplicationContext appCtx = SpringContextUtils.getApplicationContext(context);

        /**
         * Obtain the businessService Bean from the application context
         */
        final BusinessService service = appCtx.getBean(BusinessService.class);
        final List<String> headlines = service.getHeadlines();

        /**
        * Read the 'order' attribute from the tag. This optional attribute in our tag
        * will allow us to determine whether we want to show a random headline or
        * only the latest one ('latest' is default).
        */
        final String order = tag.getAttributeValue("order");

        String headlineText = null;
        if (order != null && order.trim().toLowerCase().equals("random")) {
            //order is random
            final int r = this.rand.nextInt(headlines.size());
            headlineText = headlines.get(r);
        } else {
            //order is "latest",only the latest headline will be shown
            Collections.sort(headlines);
            headlineText = headlines.get(headlines.size() - 1);
        }

        /**
         * Create the DOM structure that will be substituting our custom tag.
         * The headline will be shown inside a '<div>' tag, and so this must
         * be created first and then a Text node must be added to it.
         */
        final IModelFactory modelFactory = context.getModelFactory();

        final IModel model = modelFactory.createModel();

        model.add(modelFactory.createOpenElementTag("div","class","headlines"));
        model.add(modelFactory.createText(HtmlEscape.escapeHtml5(headlineText)));
        model.add(modelFactory.createCloseElementTag("div"));

       /**
        * Instruct the engine to replace this entire element with the specified model.
        */
        structureHandler.replaceWith(model, false);
    }
}
