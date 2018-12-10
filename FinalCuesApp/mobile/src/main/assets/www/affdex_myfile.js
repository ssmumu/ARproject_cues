
var divRoot = $("affdex_elements")[0];
var width = 640;
var height = 480;
var faceMode = affdex.FaceDetectorMode.LARGE_FACES;
var detector = new affdex.CameraDetector(divRoot, width, height, faceMode);


detector.detectAllEmotions();
detector.detectAllExpressions();
detector.detectAllEmojis();
detector.detectAllAppearance();

detector.addEventListener("onInitializeSuccess", function() {
});


var valence_val = 0.0;


function onStart() {
    document.getElementById("logs").innerHTML ="let's see";
    if (detector && !detector.isRunning) {
        document.getElementById("demos").innerHTML ="let's see";
	detector.start();
    }
    else
        document.getElementById("logs").innerHTML ="let's not see";
}

function onStop() {
    if (detector && detector.isRunning) {
	detector.removeEventListener();
	detector.stop();
    }
};

function onReset() {
    if (detector && detector.isRunning) {
	detector.reset();
    }
};

detector.addEventListener("onWebcamConnectSuccess", function() {
    document.getElementById("demos").innerHTML ="Webcam access allowed";
});

//Add a callback to notify when camera access is denied
detector.addEventListener("onWebcamConnectFailure", function() {
    document.getElementById("demos").innerHTML ="webcam denied";
});

////Add a callback to notify when detector is stopped
//detector.addEventListener("onStopSuccess", function() {
//    document.getElementById("demos").innerHTML ="The detector reports stopped";
//
//});
//
//
//detector.addEventListener("onImageResultsSuccess", function(faces, image, timestamp) {
//    document.getElementById("results").innerHTML ="";
//
//    valence_val = parseFloat(JSON.stringify(faces[0].emotions.valence, function(key, val) {
//	return val.toFixed ? Number(val.toFixed(0)) : val;
//    }));
//
//	affdex_feedback_to_user(valence_val);
//
//
//    }
//
//
//});
//
////feedback on facial emotion
//function affdex_feedback_to_user(avg_valence){
//
//
//    if(avg_valence < 0){
//        document.getElementById("results").innerHTML ="NEGATIVE";
//    }
//    else if(avg_valence == 0){
//	    document.getElementById("results").innerHTML ="NEUTRAL";
//    else{
//         document.getElementById("results").innerHTML ="POSITIVE";
//
//
//}
//
//
