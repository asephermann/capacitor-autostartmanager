# capacitor-autostartmanager

Auto Start Manager, Check Automatic Date Time Zone, Check Camera

## Install

```bash
npm install capacitor-autostartmanager
npx cap sync
```

## API

<docgen-index>

* [`showStartManager()`](#showstartmanager)
* [`checkAutomaticDateTimeZone()`](#checkautomaticdatetimezone)
* [`checkCamera()`](#checkcamera)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### showStartManager()

```typescript
showStartManager() => Promise<void>
```

--------------------


### checkAutomaticDateTimeZone()

```typescript
checkAutomaticDateTimeZone() => Promise<{ isAutomatic: Boolean; }>
```

**Returns:** <code>Promise&lt;{ isAutomatic: <a href="#boolean">Boolean</a>; }&gt;</code>

--------------------


### checkCamera()

```typescript
checkCamera() => Promise<{ isCameraOpen: Boolean; }>
```

**Returns:** <code>Promise&lt;{ isCameraOpen: <a href="#boolean">Boolean</a>; }&gt;</code>

--------------------


### Interfaces


#### Boolean

| Method      | Signature        | Description                                          |
| ----------- | ---------------- | ---------------------------------------------------- |
| **valueOf** | () =&gt; boolean | Returns the primitive value of the specified object. |

## Example

### Show Start manager

```typescript
import { AutoStartManager } from 'capacitor-autostartmanager';


showStartManager = async () => {
    await AutoStartManager.showStartManager();
};

```

### Check Automatic Date TimeZone

```typescript
import { AutoStartManager } from 'capacitor-autostartmanager';


checkAutomaticDateTimeZone = async () => {
    const result = await AutoStartManager.checkAutomaticDateTimeZone();

    console.log('Automatic Date Time Zone:', result.isAutomatic);
};

```
![enableautomaticdatetime](https://github.com/asephermann/pictures/blob/main/enableautomaticdatetime.jpg)

### Check Camera

```typescript
import { AutoStartManager } from 'capacitor-autostartmanager';


checkCamera = async () => {
    const result = await AutoStartManager.checkCamera();

    console.log('Camera Open:', result.isCameraOpen);
};

```
</docgen-api>