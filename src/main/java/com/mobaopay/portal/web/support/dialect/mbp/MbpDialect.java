package com.mobaopay.portal.web.support.dialect.mbp;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruby on 2016/6/1.
 * Email:liyufeng_23@163.com
 */
public class MbpDialect extends AbstractProcessorDialect {

    private static final String DIALECT_NAME = "MBP Dialect";

    protected MbpDialect() {

        // We will set this dialect the same "dialect processor" precedence as
        // the Standard Dialect, so that processor executions can interleave.
        super(DIALECT_NAME, "mbp", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    /**
     * Two attribute processors are declared: 'classforposition' and
     * 'remarkforposition'. Also one element processor: the 'headlines'
     * tag.
     */
    @Override
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new ClassForPositionAttributeTagProcessor(dialectPrefix));
        processors.add(new RemarkForPositionAttributeTagProcessor(dialectPrefix));
        processors.add(new SensitiveDataProtectionAttributeTagProcessor(dialectPrefix));
        processors.add(new HeadlinesElementTagProcessor(dialectPrefix));
        processors.add(new WeekdayModelProcessor(dialectPrefix));
        return processors;
    }
}
