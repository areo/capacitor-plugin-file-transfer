
  Pod::Spec.new do |s|
    s.name = 'CapacitorPluginFileTransfer'
    s.version = '0.0.1'
    s.summary = 'Capacitor plugin for downloading files'
    s.license = 'MIT'
    s.homepage = 'https://github.com/areo/capacitor-plugin-file-transfer'
    s.author = 'Areo AS'
    s.source = { :git => 'https://github.com/areo/capacitor-plugin-file-transfer', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '10.0'
    s.dependency 'Capacitor'
  end
