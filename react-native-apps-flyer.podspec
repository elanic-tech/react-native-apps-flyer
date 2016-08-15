require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name                = "react-native-apps-flyer"
  s.version             = package['version']
  s.summary             = package['description']
  s.homepage            = "https://github.com/ppsreejith/react-native-apps-flyer"
  s.license             = package['license']
  s.author              = "Sreejith Pp"
  s.source              = { :git => "https://github.com/ppsreejith/react-native-apps-flyer.git" }
  s.platform            = :ios, "9.0"
  s.source_files  = "ios/*.{h,m}"
end
