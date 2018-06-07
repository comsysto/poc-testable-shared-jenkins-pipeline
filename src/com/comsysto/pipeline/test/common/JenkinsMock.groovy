package com.comsysto.pipeline.test.common;

class JenkinsMock {

    //
    // INTERNAL SPYS
    //
    def recordecShCalls = [] as ArrayList

    //
    // MOCKS
    //
    def env = [] as LinkedHashMap<String,Object>

    def sh (String command) {
        this.recordecShCalls.add(command)
    }

    def withCredentials(ArrayList credentials, Closure cl) {
        if (credentials[0]['credentialsId'] == 'github-credentials-1') {
            this.env['githubUsername'] = 'unused'
            this.env['githubPassword'] = 'MYTOKEN'
        }
        cl()
    }

}
