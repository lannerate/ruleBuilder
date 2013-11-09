package com.flagleader.builder.a.b;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class J
  implements DragSourceListener
{
  J(I paramI)
  {
  }

  public void dragStart(DragSourceEvent paramDragSourceEvent)
  {
    if ((I.a(this.a).getSelectionCount() == 1) && ((I.a(this.a).getSelection()[0].getData() instanceof IBusinessObjectEditen)))
      paramDragSourceEvent.doit = true;
    else
      paramDragSourceEvent.doit = false;
  }

  public void dragSetData(DragSourceEvent paramDragSourceEvent)
  {
    if (d.a().isSupportedType(paramDragSourceEvent.dataType))
      paramDragSourceEvent.data = I.a(this.a).getSelection()[0].getData();
  }

  public void dragFinished(DragSourceEvent paramDragSourceEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.J
 * JD-Core Version:    0.6.0
 */