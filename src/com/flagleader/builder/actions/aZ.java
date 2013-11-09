package com.flagleader.builder.actions;

import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class aZ
  implements DragSourceListener
{
  aZ(aO paramaO)
  {
  }

  public void dragStart(DragSourceEvent paramDragSourceEvent)
  {
    if (aO.c(this.a).getSelectionCount() == 1)
    {
      if (!((ITreeNode)aO.c(this.a).getSelection()[0].getData()).canCut())
        paramDragSourceEvent.doit = false;
    }
    else
      paramDragSourceEvent.doit = false;
  }

  public void dragSetData(DragSourceEvent paramDragSourceEvent)
  {
    if (TextTransfer.getInstance().isSupportedType(paramDragSourceEvent.dataType))
      paramDragSourceEvent.data = ((ITreeNode)aO.c(this.a).getSelection()[0].getData()).getEditUuid();
  }

  public void dragFinished(DragSourceEvent paramDragSourceEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aZ
 * JD-Core Version:    0.6.0
 */