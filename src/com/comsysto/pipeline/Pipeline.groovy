package com.comsysto.pipeline;

import com.comsysto.pipeline.libs.GitHelper;

def getGitHelper(jenkins) {
    return new GitHelper(jenkins);
}

return this
