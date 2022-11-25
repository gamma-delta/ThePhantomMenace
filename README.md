# The Phantom Menace

Helps you deal wth the menace that is the Phantom mob.

Getting the Speed potion effect, or eating a Glow Berry, will reset your sleep timer as if you had slept in a bed.

## For Modpack Makers

You can customize which potion effects/items reset the timer! The key tag is `thephantommenace:phantom_banisher`.

- As an item tag controls which used items reset the timer (not necessarily just food)
- As a mob effect tag, it controls which potion effect tags reset the timer. (Put it in
  `data/[namespace]/tags/mob_effect/phantom_banisher.json`)

The mod just uses its own tags, so check
out [the tag definitions it uses](src/main/resources/data/thephantommenace/tags).
