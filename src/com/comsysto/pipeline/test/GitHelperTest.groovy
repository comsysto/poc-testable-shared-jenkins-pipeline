package com.comsysto.pipeline.test;

import com.comsysto.pipeline.libs.GitHelper;
import com.comsysto.pipeline.test.common.JenkinsMock;

class GitHelperTest extends GroovyTestCase {

    void testCloneGitHubRepository() {
        def jenkinsMock = new JenkinsMock();
        def gitHelper = new GitHelper(jenkinsMock);

        gitHelper.cloneGitHubRepository(
          "github-credentials-1",
          "comsysto",
          "poc-java-i18n-pluralization"
        )

        // You can print the shell calls:
        // printf jenkinsMock.recordecShCalls[1]

        assert jenkinsMock.recordecShCalls[0] == 'git clone https://HANS:DAMPF@github.com/comsysto/poc-java-i18n-pluralization.git source'
    }
}
