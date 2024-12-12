pipeline {
    agent any

    environment {
        GITHUB_TOKEN = credentials('TokenMiguel')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
    }

    post {
        success {
            script {
                updateGitHubStatus('SUCCESS', 'Build and coverage passed')
            }
        }

        failure {
            script {
                updateGitHubStatus('FAILURE', 'Build or coverage failed')
            }
        }
    }
}

def updateGitHubStatus(String state, String description) {
    def context = "continuous-integration/jenkins"
    def commitSha = env.GIT_COMMIT

    withCredentials([usernamePassword(credentialsId: 'TokenMiguel', usernameVariable: 'Miguel22hp', passwordVariable: 'GITHUB_TOKEN')]) {
        def apiUrl = "https://api.github.com/repos/Miguel22hp/PROF-2024-control1.git/statuses/${commitSha}"
        def data = """
        {
            "state": "${state}",
            "description": "${description}",
            "context": "${context}"
        }
        """
        sh "curl -X POST -H 'Authorization: token ${GITHUB_TOKEN}' -d '${data}' ${apiUrl}"
    }
}