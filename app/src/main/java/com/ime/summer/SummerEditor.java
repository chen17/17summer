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

import android.util.Log;

/**
 * Extends Editor to compose by Summer rules. 
 */
public class SummerEditor extends Editor {

  @Override
  public boolean doCompose(int keyCode) {
	Log.i("i", "Summer DeCompose");
    char c = (char) keyCode;
    if (!SummerTable.isLetter(c)) {
      return false;
    }

    int maxLength = 4;
    if (composingText.length() >= maxLength) {
      // Handle the key-code with no-op.
      return true;
    }

    composingText.append(c);
    return true;
  }
}
