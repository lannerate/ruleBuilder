package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.action.AbstractPackageField;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;

class E
  implements TraverseListener
{
  E(C paramC, CCombo paramCCombo, TableItem paramTableItem, int paramInt, List paramList)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 4) || (paramTraverseEvent.detail == 16))
    {
      if (this.b.getSelectionIndex() >= 0)
      {
        AbstractPackageField localAbstractPackageField = (AbstractPackageField)this.c.getData();
        if (this.d == 0)
          localAbstractPackageField.setMappingField((IBusinessObject)this.e.get(this.b.getSelectionIndex()));
        this.c.setText(0, localAbstractPackageField.getFuncName());
        this.c.setText(1, localAbstractPackageField.getNaryType());
        this.c.setText(2, localAbstractPackageField.getDisplayName());
        C.a(this.a).setModified(true);
      }
      this.b.dispose();
      C.k(this.a).setEditor(null, null, -1);
    }
    if (paramTraverseEvent.detail == 2)
    {
      this.b.dispose();
      C.k(this.a).setEditor(null, null, -1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.E
 * JD-Core Version:    0.6.0
 */