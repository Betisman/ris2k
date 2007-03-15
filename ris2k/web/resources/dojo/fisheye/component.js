dojo.require("dojo.widget.FisheyeList");

// define the namespaces
jmaki.namespace("jmaki.widgets.dojo.fisheye");

jmaki.widgets.dojo.fisheye.Widget = function(wargs) {

    // create the top level widget
    var container = document.getElementById(wargs.uuid);
    var dynaCallback = null;

    if (typeof _globalScope.DynaFaces != 'undefined') {
      // Find the form for this widget
      var containerForm  = container;
      while (null != containerForm && 
         -1 == containerForm.tagName.toLowerCase().indexOf("form")) {
          containerForm = containerForm.parentNode;
      }
      // Save it on the widget so we have access to it in the listener.
      wargs.form = containerForm;
    }
    
    // default topic
    var topic = "/dojo/fisheye";
    var orientation = "horizontal";
    var labelEdge = "bottom";
    var items = ["item1","item2","item3"];

    if (wargs.args) {
        if (wargs.args.orientation){
           orientation = wargs.args.orientation;
           if (orientation == "vertical") {
               labelEdge = "right";
           }
        }
        if (wargs.args.labelEdge){
               labelEdge = wargs.args.labelEdge;
        }
        
        if (wargs.args.topic) {
            topic = wargs.args.topic;
        }
        if (wargs.args.items) {
            items = wargs.args.items;
        }
    }
    
    if (wargs.value && typeof wargs.value == 'object') {
        items = wargs.value;
    }
    
    var fishEye =  dojo.widget.createWidget("FishEyeList", 
        { 	orientation : orientation, 
            itemWidth:50,
            itemHeight:50,
            itemMaxWidth:200,
            itemMaxHeight:200,
            effectUnits:2,
            itemPadding:10,
            attachEdge:"top",
            labelEdge:labelEdge,
            enableCrappySvgSupport:false
        }, container);


    // default values

    // programtically add FisheyeListItem children to the widget
    var counter = 0;
    while (true) {
        var i = items[counter++];
        if (i == null) break;
        var icon = dojo.widget.createWidget("FisheyeListItem", i);

        icon.onClick = function () {
            jmaki.publish(topic, {target:this, wargs:wargs});
        }
        fishEye.addChild(icon);
    }

     this.destroy = function() {
        if (typeof dynaCallback != 'undefined') {
            jmaki.unsubscribe(topic, dynaCallback);
        }
     }
}