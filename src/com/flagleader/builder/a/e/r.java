package com.flagleader.builder.a.e;

import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class r
  implements DragSourceListener
{
  r(q paramq)
  {
  }

  public void dragStart(DragSourceEvent paramDragSourceEvent)
  {
    if (q.a(this.a).getSelectionCount() == 1)
    {
      if (!((ITreeNode)q.a(this.a).getSelection()[0].getData()).canCopy())
        paramDragSourceEvent.doit = false;
    }
    else
      paramDragSourceEvent.doit = false;
  }

  public void dragSetData(DragSourceEvent paramDragSourceEvent)
  {
    if (TextTransfer.getInstance().isSupportedType(paramDragSourceEvent.dataType))
      paramDragSourceEvent.data = ((ITreeNode)q.a(this.a).getSelection()[0].getData()).getUuid();
  }

  public void dragFinished(DragSourceEvent paramDragSourceEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.r
 * JD-Core Version:    0.6.0
 */