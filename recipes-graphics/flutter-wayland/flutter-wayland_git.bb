LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a60894397335535eb10b54e2fff9f265"

SRCREV = "992de83dba5c9510c2a234e89867f5095ee99a42"
SRC_URI = "git://github.com/jwinarske/flutter_wayland;protocol=https;branch=yocto_zeus"

DEPENDS =+ " flutter-engine wayland mesa"

RDEPENDS_${PN} = "flutter-engine wayland mesa freetype"

REQUIRED_DISTRO_FEATURES = "wayland"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DFLUTTER_ENGINE_LIBRARY=${STAGING_LIBDIR}/libflutter_engine.so \
    "

FILES_${PN}  = "${bindir}/flutter_wayland"