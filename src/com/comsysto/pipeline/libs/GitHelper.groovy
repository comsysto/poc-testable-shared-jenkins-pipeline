package com.comsysto.pipeline.libs;

class GitHelper {

    def jenkins

    GitHelper(_jenkins) {
        this.jenkins = _jenkins
    }

    def cloneGitHubRepository(String credentialsId, String owner, String repository) {
        jenkins.withCredentials([[$class: 'UsernamePasswordMultiBinding',
            credentialsId   : credentialsId,
            usernameVariable: 'githubUsername',
            passwordVariable: 'githubPassword']]) {

            jenkins.sh 'git clone https://' +
                    jenkins.env.githubUsername +
                    ':' +
                    jenkins.env.githubPassword +
                    '@github.com/' +
                    owner +
                    '/'+
                    repository +
                    '.git source'
        }
    }
}
