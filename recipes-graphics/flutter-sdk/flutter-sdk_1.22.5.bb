SUMMARY = "Flutter - Dart based UI framework SDK"
WEBSITE = "https://flutter.dev/"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d84cf16c48e571923f837136633a265"

SRC_URI = "git://github.com/flutter/flutter.git;branch=stable"
SRCREV="78910062997c3a836feee883712c241a5fd22983"

S = "${WORKDIR}/git"

DEPENDS = "curl unzip"
RDEPENDS_${PN} = "bash curl file perl git unzip xz zip"

do_install() {
    install -d ${D}${datadir}/flutter/sdk
    cp -rTv ${S}/. ${D}${datadir}/flutter/sdk
}

FILES_${PN}-dev = "${datadir}/flutter/sdk/*"
FILES_${PN}-dev += "${datadir}/flutter/sdk/.*"

INSANE_SKIP_${PN} = "already-stripped"

BBCLASSEXTEND =+ " native nativesdk"