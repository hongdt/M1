var EzoicAnalytics = function() {

    // this is the callback url to store the impression via ajax!!
    this.defaultStoreUrl = "/ezoic/imp.gif";
    this.defaultStoreA = "/ezoic/i.gif";
    if (((typeof ezJsu !== 'undefined') && ezJsu === true) || ((typeof _ez_sa !== 'undefined') && _ez_sa === true)) {
        this.defaultStoreUrl = "//g.ezoic.net/ezoic/imp.gif";
        this.defaultStoreA = "//g.ezoic.net/ezoic/i.gif";
    }

    this.getStoreImpressionUrl = function() {
        if (typeof _ezImpStoreUrl != 'undefined') {
            return _ezImpStoreUrl;
        } else {
            return this.defaultStoreUrl;
        }
    };

    this.getExtraQueries = function() {
        if (typeof _ezExtraQueries != 'undefined') {
            return _ezExtraQueries;
        } else {
            return "";
        }
    };

    this.getStoreAUrl = function() {
        return this.defaultStoreA;
    };

    // store the impression data
    this.storeImpression = function() {

        // If the page is in prerender mode, do not store the pageview impression
        if(typeof document.visibilityState != 'undefined' && document.visibilityState == "prerender") {
            return;
        }
        if (typeof _ezaq != "undefined") {

            var img = new Image();
            img.src = this.getStoreImpressionUrl() + "?e=" + encodeURIComponent(JSON.stringify(_ezaq)) + this.getExtraQueries();

            _ezaq.pv_event_count = (typeof _ezaq.pv_event_count == 'undefined') ? 1 : _ezaq.pv_event_count+1;
        }
    };
    this.storeA = function(iid, u, ss, h) {

        // If the page is in prerender mode, do not store the pageview impression
        if(typeof document.visibilityState != 'undefined' && document.visibilityState == "prerender") {
            return;
        }
        if (typeof iid !== "undefined" && typeof u !== "undefined" && typeof ss !== "undefined") {
            var img = new Image();
            img.src = this.getStoreAUrl() + "?impid="+iid+"&unit="+encodeURIComponent(u)+"&ss="+ss+"&h="+h;
        }
    };

};
new EzoicAnalytics().storeImpression();


var EzoicPixel = function() {
    this.pixels = [];
    this.util = new EzoicPixelUtil();
    this.pixelUrl =  "/ezoic/e.gif";
    if ((typeof ezJsu !== "undefined" && ezJsu === true) || (typeof _ez_sa !== "undefined" && _ez_sa === true)) {
        this.pixelUrl = "//g.ezoic.net" + this.pixelUrl;
    }
    this.tEpoch = 0;
    if (typeof _ezaq !== "undefined" && _ezaq.hasOwnProperty("t_epoch")) {
        this.tEpoch = _ezaq.t_epoch;
    }
};
var EzoicPixelData = function(name, val) {
    this.name = name;
    this.val = val;
};
var EzoicPixelUtil = function() {};
EzoicPixel.prototype = {
    constructor: EzoicPixel,
    AddAndFireImpPixel: function(adSlot, pixelData) {
        this.AddImpPixel(adSlot, pixelData, 0);
        this.FirePixels();
    },
    AddAndFirePVPixel: function(adSlot, pixelData) {
        this.AddPVPixel(adSlot, pixelData);
        this.FirePixels();
    },
    AddImpPixel: function(adSlot, pixelData, revenue) {
        if (!this.isDefined(adSlot, adSlot.getSlotElementId)) {
            return;
        }
        var impId = this.util.getSlotIID(adSlot), adUnit = adSlot.getSlotElementId();
        if (this.isDefined(impId, adUnit) && this.validateData(pixelData)) {
            pixelData = this.util.convertDataToStr(pixelData);
            this.pixels.push({type: "impression", impression_id: impId, unit: adUnit, t_epoch: this.tEpoch, revenue: revenue, data: pixelData});
        }
    },
    AddPVPixel: function(pvId, pixelData) {
        if (this.isDefined(pvId) && this.validateData(pixelData)) {
            pixelData = this.util.convertDataToStr(pixelData);
            this.pixels.push({type: "pageview", pageview_id: pvId, t_epoch: this.tEpoch, data: pixelData});
        }
    },
    FirePixels: function() {
        if (typeof document.visibilityState != 'undefined' && document.visibilityState == "prerender") {
            return;
        }
        if (this.isDefined(this.pixels) && this.pixels.length > 0) {
            (new Image()).src = this.pixelUrl + "?pixels=" + encodeURIComponent(JSON.stringify(this.pixels));
        }
        this.pixels = [];
    },
    NewData: function(name, val) {
        return new EzoicPixelData(name, val);
    },
    isDefined: function() {
        for (var i = 0; i < arguments.length; i++) {
            if (typeof arguments[i] === 'undefined' || arguments[i] === null) {
                console.error("Argument not defined. ", arguments);
                return false;
            }
        }
        return true;
    },
    validateData: function(pixelData) {
        for (var i in pixelData) {
            if (pixelData[i] instanceof EzoicPixelData === false) {
                console.error("Invalid pixelData. ", pixelData[i]);
                return false;
            }
        }
        return true;
    }
};
EzoicPixelUtil.prototype = {
    constructor: EzoicPixelUtil,
    convertDataToStr: function(pixelData) {
        if (typeof pixelData === "undefined") {
            return [];
        }
        try {
            for (var i in pixelData) {
                pixelData[i].val = pixelData[i].val + '';
            }
        } catch (e) {}
        return pixelData;
    },
    getSlotIID: function(slot) {
        var iid = 0;
        try {
            var map = slot.getTargetingMap(), dvid = slot.getSlotElementId();
            if (dvid.indexOf("div-gpt-ad") === -1) { return iid; }
            if (typeof map !== "undefined") {
                for (var key in map) {
                    if (key.indexOf('iid') !== -1 && typeof map[key][0] !== "undefined") {
                        iid = map[key][0];
                        break;
                    }
                }
            }
        } catch (e) {}
        return iid;
    }
};
