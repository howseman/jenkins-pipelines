job('build-nodejs-app') {
  parameters {
    stringParam('APP_NAME', '', 'The application name to be built')
  }
  scm {
    git {
      remote {
        url('https://github.com/howseman/jenkins-pipelines.git')
      }
      branch('$JOB_BRANCH_NAME')
    }
  }
  steps {
    script {
      def projectName = params.APP_NAME ?: ""
      pipelineJob("nodejs-app-${projectName}") {
        definition {
          cps {
            script(readFileFromWorkspace('./${projectName}/Jenkinsfile'))
          }
        }
        parameters {
          string(name: 'JOB_BRANCH_NAME', defaultValue: 'main', description: 'The branch to be built')
        }
      }
    }
  }
}
