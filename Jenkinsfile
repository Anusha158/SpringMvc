node{
stage('SCM Checkout'){
  
git 'https://github.com/Anusha158/SpringMvc'
}
stage('Compile-Package'){
  def mvHome=tool name: 'MAVEN_HOME', type: 'maven'
  bat "${mvHome}/bin/mvn package"
}
}
