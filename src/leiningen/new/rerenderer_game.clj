(ns leiningen.new.rerenderer-game
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files
                                             raw-resourcer sanitize]]
            [leiningen.core.main :as main]))

(def render (renderer "rerenderer-game"))
(def copy (raw-resourcer "rerenderer-game"))

(defn rerenderer-game
  [name]
  (let [data {:name name
              :path (name-to-path name)
              :sanitized (sanitize name)}]
    (main/info "Generating fresh 'lein new' rerenderer-game project.")
    (->files data
             ; Core part
             ["src/{{path}}/core.cljs" (render "core.cljs" data)]
             ["project.clj" (render "project.clj" data)]
             ; Html for web-platform
             ["resources/public/index.html" (render "index.html" data)]
             ; Player for android-platform:
             ["android/build.gradle" (copy "android/build.gradle")]
             ["android/gradle.properties" (copy "android/gradle.properties")]
             ["android/gradlew" (copy "android/gradlew")]
             ["android/settings.gradle" (copy "android/settings.gradle")]
             ["android/gradle/wrapper/gradle-wrapper.jar" (copy "android/gradle/wrapper/gradle-wrapper.jar")]
             ["android/gradle/wrapper/gradle-wrapper.properties" (copy "android/gradle/wrapper/gradle-wrapper.properties")]
             ["android/app/build.gradle" (render "android/app/build.gradle" data)]
             ["android/app/proguard-rules.pro" (copy "android/app/proguard-rules.pro")]
             ["android/app/src/main/AndroidManifest.xml" (render "android/app/AndroidManifest.xml" data)]
             ["android/app/src/main/{{path}}/MainActivity.java" (render "android/app/MainActivity.java" data)])))
