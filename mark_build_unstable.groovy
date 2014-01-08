//
// Forces build status to UNSTABLE if one of these conditions is met:
//    1. PhantomJS produces an "unexpected response" error
//    2. Chrome produces an "unreachable" error
//
// PhantomJS produces the "unexpected response" error when too many instances
// are running simultaneously. Run multi-config jobs sequentially to avoid this. 
// I cannot explain the Chrome error.
//

def chrome_error = manager.logContains('.*chrome not reachable.*')
def phantom_error = manager.logContains('.*unexpected response, code=404, content-type="text/plain".*')

if (chrome_error || phantom_error) {
  manager.build.@result = hudson.model.Result.UNSTABLE
}

