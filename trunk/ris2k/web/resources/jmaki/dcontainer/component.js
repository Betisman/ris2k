/* Copyright 2005 Sun Microsystems, Inc. All rights reserved. You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: http://developer.sun.com/berkeley_license.html
$Id: component.js,v 1.6 2007/02/05 06:35:48 gmurray71 Exp $
*/

// define the namespaces
if (!jmaki.widgets.jmaki) {
    jmaki.widgets.jmaki = {};
}
jmaki.widgets.jmaki.dcontainer = {};

jmaki.widgets.jmaki.dcontainer.Widget = function(wargs) {
    var self = this;
    this.url;
    this.uuid = wargs.uuid;
    var startHeight;
    var startWidth;
    var overflow;
    var useIframe = false;
    var autosize = true;
    // subscribe to this topic for url update requests
    var topic = "/jmaki/menu";    

    if (wargs.args){
        if (wargs.args.height){
            startHeight = wargs.args.height;
        }
        if (typeof wargs.args.width != 'undefined'){
            startWidth = wargs.args.width;
        }   
        if (wargs.args.overflow){
            overflow = wargs.args.overflow;
        }   
        if (wargs.args.iframe){
            useIframe = (wargs.args.iframe == 'true' || wargs.args.iframe);
        }
        if (wargs.args.topic) {
            topic = wargs.args.topic;
        }
        if (wargs.args.autosize) {
            autosize = wargs.args.autosize;
        }
        
   }
    
   this.dcontainer = new jmaki.DContainer(
            {target: document.getElementById(self.uuid),
             useIframe : useIframe,
             overflow: overflow,
             topic : topic,
             startHeight : startHeight,
             startWidth : startWidth,
             autosize : autosize,
             url : this.url});    

}