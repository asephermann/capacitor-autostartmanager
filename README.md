# capacitor-autostartmanager

Auto Start Manager, Check Automatic Date Time Zone, Check Camera

## Install

```bash
npm install capacitor-autostartmanager
npx cap sync
```

## Example

### Check Automatic Date TimeZone

```typescript
import { AutoStartManager } from 'capacitor-autostartmanager';


checkAutomaticDateTimeZone = async () => {
    const result = await AutoStartManager.checkAutomaticDateTimeZone();

    console.log('Automatic Date Time Zone:', result.isAutomatic);
  };
```


## API

<docgen-index>

* [`checkAutomaticDateTimeZone()`](#checkautomaticdatetimezone)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### checkAutomaticDateTimeZone()

```typescript
checkAutomaticDateTimeZone() => Promise<{ isAutomatic: Boolean; }>
```

**Returns:** <code>Promise&lt;{ isAutomatic: <a href="#boolean">Boolean</a>; }&gt;</code>

--------------------


### Interfaces


#### Boolean

| Method      | Signature        | Description                                          |
| ----------- | ---------------- | ---------------------------------------------------- |
| **valueOf** | () =&gt; boolean | Returns the primitive value of the specified object. |

</docgen-api>
