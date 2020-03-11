/*
 * The MIT License
 *
 * Copyright 2020 CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.docker.workflow.declarative;

import java.util.HashMap;
import java.util.Map;
import org.jenkinsci.plugins.pipeline.modeldefinition.agent.DeclarativeAgentDescriptor;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.Issue;
import org.jvnet.hudson.test.JenkinsRule;

@Issue("JENKINS-58732")
public class ExtensionFilterImplTest {

    @Rule
    public JenkinsRule r = new JenkinsRule();

    @Test
    public void noOverlap() throws Exception {
        Map<String, DeclarativeAgentDescriptor> dads = new HashMap<>();
        for (DeclarativeAgentDescriptor dad : DeclarativeAgentDescriptor.all()) {
            DeclarativeAgentDescriptor dad2 = dads.put(dad.getName(), dad);
            assertNull("clash between " + dad2 + " and " + dad, dad2);
        }
    }

}
