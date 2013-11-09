package com.flagleader.builder.a;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import com.flagleader.repository.rom.IBusinessObject;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class z
  implements Listener
{
  z(w paramw, IModifierEditen paramIModifierEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(d.a());
    boolean bool = false;
    if ((localObject != null) && ((localObject instanceof IElement)))
      bool = this.b.canPasteElement((IElement)localObject);
    if (bool)
    {
      if ((localObject instanceof IBusinessObject))
        this.b.pasteElement((IBusinessObject)localObject);
      else
        this.b.pasteElement(((IElement)localObject).deepClone());
      w.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.z
 * JD-Core Version:    0.6.0
 */