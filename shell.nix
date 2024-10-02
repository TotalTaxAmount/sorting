{ pkgs ? (import <nixpkgs> {
    config.allowUnfree = true;
}) }:

pkgs.stdenv.mkDerivation {
    name = "sorting";

   buildInputs = with pkgs; [
     (jdk21.override { enableJavaFX = true; })
     maven
   ];
   shellHook = ''
       export JAVA_HOME=${pkgs.jdk21}
       export LD_LIBRARY_PATH=${pkgs.lib.makeLibraryPath [
        pkgs.javaPackages.openjfx21
        pkgs.gtk3
        (pkgs.jdk21.override { enableJavaFX = true; })
       ] }:$LD_LIBRARY_PATH
       '';
}
