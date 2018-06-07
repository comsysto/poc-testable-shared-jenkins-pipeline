package com.comsysto.pipeline.test;

import com.comsysto.pipeline.libs.GitHelper;
import com.comsysto.pipeline.test.common.JenkinsMock;

@Grab('org.yaml:snakeyaml:1.21')
import org.yaml.snakeyaml.Yaml;

class GitHelperTest extends GroovyTestCase {

    def config = new Yaml().load('''
gitHelper:
  testConfig:
    credentialId: github-credentials-1
    repositoryOwner: comsysto
    repositoryName: poc-java-i18n-pluralization
''')

    void testCloneGitHubRepository() {
        def jenkinsMock = new JenkinsMock();
        def gitHelper = new GitHelper(jenkinsMock);

        def testConfig = config.gitHelper.testConfig;

        gitHelper.cloneGitHubRepository(
          testConfig.credentialId,
          testConfig.repositoryOwner,
          testConfig.repositoryName
        )

        // You can print the shell calls:
        // printf jenkinsMock.recordecShCalls[1]

        assert jenkinsMock.recordecShCalls[0] == 'git clone ' +
          'https://MYTOKEN@github.com/comsysto/poc-java-i18n-pluralization.git' +
          ' source'
    }
}
