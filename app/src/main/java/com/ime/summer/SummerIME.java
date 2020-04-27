/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ime.summer;

import android.content.Context;
import android.util.Log;

/**
 * Zhuyin input method.
 */
public class SummerIME extends AbstractIME {

	private String TAG = "";
	private boolean D = true;
	
  @Override
  protected KeyboardSwitch createKeyboardSwitch(Context context) {
	  TAG = this.getClass().getSimpleName();
	  if (D) {
		  Log.i(TAG, "Summer Loaded\n");
	  }
    return new KeyboardSwitch(context, R.xml.summer);
  }

  @Override
  protected Editor createEditor() {
    return new SummerEditor();
  }

  @Override
  protected WordDictionary createWordDictionary(Context context) {
    return new SummerDictionary(context);
  }
}
