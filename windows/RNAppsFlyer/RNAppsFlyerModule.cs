
using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Reactlibrary.RNAppsFlyer
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNAppsFlyerModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNAppsFlyerModule"/>.
        /// </summary>
        internal RNAppsFlyerModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNAppsFlyer";
            }
        }
    }
}
