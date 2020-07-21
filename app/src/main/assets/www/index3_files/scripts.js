// -------------- initial resize ------------
window.addEventListener('resize', resizeMainFieldSizeFix);
function resizeMainFieldSizeFix() {
	//console.log("resizeMainFieldSizeFix");
	let controllerElement = document.getElementById('full_screen_special_windows_wrap');
	let formerElement = document.getElementById('field_former_element');
	//console.log(controllerElement.offsetHeight);
	//console.log(controllerElement.scrollHeight);
	//console.log(formerElement.offsetHeight);
	//console.log(formerElement.scrollHeight);
	let isWasChanges = false;

	if (formerElement.scrollHeight > controllerElement.offsetHeight) {
		// error fixing
		if (controllerElement.offsetHeight == 430) {
			formerElement.style.height = "auto";
		} else {
			formerElement.style.height = controllerElement.offsetHeight + "px";
		}
		isWasChanges = true;
	} else if (formerElement.scrollHeight < controllerElement.offsetHeight && formerElement.scrollWidth < controllerElement.offsetWidth) {
		// fixing error fixing, egrh - rarely if window/wrapper size will be changed
		formerElement.style.height = "auto";
		isWasChanges = true;
		// and fix for full screen toogle
		if (formerElement.scrollHeight > controllerElement.offsetHeight) {
			formerElement.style.height = controllerElement.offsetHeight + "px";
		}
	}

	// try to update game fields
	if (isWasChanges) {
		if (typeof resizeMainFieldSizeFixWasLaunchedAlredy !== "undefined" && resizeMainFieldSizeFixWasLaunchedAlredy) {
			if (typeof cadaBttlrl !== "undefined") {
				cadaBttlrl.recreateMapObjectsWithNewKIndexSize();
			}
		}
	}
}
resizeMainFieldSizeFix();
resizeMainFieldSizeFixWasLaunchedAlredy = true;


// --------------- start --------------------
let cadaBttlrlGeneralCache = new CadaBttlrlGeneralCache();
// main game:
let cadaBttlrl = new CadaBttlrl();
cadaBttlrl.init();


