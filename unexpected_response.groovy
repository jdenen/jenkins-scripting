// 
// unstable build caused by unexpected response
//
if(manager.logContains('.*unexpected response, code=404, content-type="text/plain".*')) {
  manager.addWarningBadge("unexpected response (PhantomJS error)");
  manager.build.@result = hudson.model.Result.UNSTABLE
}
