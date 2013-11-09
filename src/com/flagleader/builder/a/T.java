package com.flagleader.builder.a;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;

class T
  implements DropTargetListener
{
  T(b paramb, ISelectorEditen paramISelectorEditen)
  {
  }

  public void dragEnter(DropTargetEvent paramDropTargetEvent)
  {
    if (paramDropTargetEvent.detail == 16)
      paramDropTargetEvent.detail = 2;
  }

  public void dragOperationChanged(DropTargetEvent paramDropTargetEvent)
  {
    if (paramDropTargetEvent.detail == 16)
      paramDropTargetEvent.detail = 2;
  }

  public void dragOver(DropTargetEvent paramDropTargetEvent)
  {
    paramDropTargetEvent.feedback = 17;
  }

  public void drop(DropTargetEvent paramDropTargetEvent)
  {
    Object localObject;
    if (TextTransfer.getInstance().isSupportedType(paramDropTargetEvent.currentDataType))
    {
      if (paramDropTargetEvent.item == null)
        return;
      localObject = (String)paramDropTargetEvent.data;
      if (paramDropTargetEvent.detail == 2)
        this.b.pasteBusinessObject(localObject);
      else if (paramDropTargetEvent.detail == 1)
        this.b.pasteBusinessObject(localObject);
    }
    else if (d.a().isSupportedType(paramDropTargetEvent.currentDataType))
    {
      localObject = paramDropTargetEvent.data;
      this.b.pasteBusinessObject(localObject);
    }
  }

  public void dragLeave(DropTargetEvent paramDropTargetEvent)
  {
  }

  public void dropAccept(DropTargetEvent paramDropTargetEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.T
 * JD-Core Version:    0.6.0
 */