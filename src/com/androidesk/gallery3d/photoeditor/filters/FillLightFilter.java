/*
 * Copyright (C) 2010 The Android Open Source Project
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

package com.androidesk.gallery3d.photoeditor.filters;

import android.annotation.TargetApi;
import android.media.effect.Effect;
import android.media.effect.EffectFactory;
import android.os.Build;

import com.androidesk.gallery3d.photoeditor.Photo;

/**
 * Fill-light filter applied to the image.
 */
public class FillLightFilter extends Filter {

    private float backlight;

    /**
     * Sets the backlight level.
     *
     * @param backlight ranges from 0 to 1.
     */
    public void setBacklight(float backlight) {
        this.backlight = backlight;
        validate();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void process(Photo src, Photo dst) {
        Effect effect = getEffect(EffectFactory.EFFECT_FILLLIGHT);
        effect.setParameter("strength", backlight);
        effect.apply(src.texture(), src.width(), src.height(), dst.texture());
    }
}