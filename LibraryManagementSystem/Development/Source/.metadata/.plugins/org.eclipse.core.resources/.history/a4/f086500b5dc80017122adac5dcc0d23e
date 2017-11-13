package com.cg.library.tests;

import org.hibernate.criterion.SimpleExpression;
import org.mockito.ArgumentMatcher;

public class SimpleExpressionMatcher extends ArgumentMatcher<SimpleExpression> {
    private SimpleExpression simpleExpression;

    public SimpleExpressionMatcher(SimpleExpression simpleExpression) {
        this.simpleExpression = simpleExpression;
    }

    @Override
    public boolean matches(Object argument) {
        @SuppressWarnings({"unchecked", "rawtypes"})
        SimpleExpression otherSimpleExpression = (SimpleExpression) argument;
        // somehow compare the SimpleExpressions, possibly like this:
        return this.simpleExpression.toString().equals(otherSimpleExpression.toString());
    }
}