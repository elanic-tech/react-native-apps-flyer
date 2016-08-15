require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name                = "react-native-apps-flyer"
  s.version             = "1.0.2"
  s.summary             = package['description']
  s.homepage            = "https://github.com/SocialbitGmbH/react-native-apps-flyer"
  s.license             = package['license']
  s.author              = "Socialbit GmbH"
  s.source              = { :git => "https://github.com/SocialbitGmbH/react-native-apps-flyer.git" }
  s.platform            = :ios, "9.0"
  s.source_files  = "ios/*.{h,m}"
end
